package com.example.demo.sevice;

import com.example.demo.entity.BankFeed;
import com.example.demo.entity.InternalLedger;
import com.example.demo.repository.BankFeedRepository;
import com.example.demo.repository.InternalLedgerRepository;
import com.example.demo.util.MatchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ReconciliationService {

    @Autowired
    private BankFeedRepository bankRepo;

    @Autowired
    private InternalLedgerRepository ledgerRepo;

    public void reconcile() {

        List<BankFeed> bankFeeds = bankRepo.findAll();

        for (BankFeed bank : bankFeeds) {

            BigDecimal bankAmount = bank.getDebit() != null ? bank.getDebit() : bank.getCredit();

            Optional<InternalLedger> exactMatch =
                    ledgerRepo.findAll().stream()
                            .filter(l -> {
                                BigDecimal ledgerAmount = l.getDebit() != null ? l.getDebit() : l.getCredit();
                                return l.getReferenceId().equals(bank.getReferenceId()) &&
                                       ledgerAmount != null && bankAmount != null &&
                                       ledgerAmount.compareTo(bankAmount) == 0;
                            })
                            .findFirst();

            if (exactMatch.isPresent()) {
                applyMatch(bank, exactMatch.get(), MatchType.EXACT, 100);
                continue;
            }

            Optional<InternalLedger> partialMatch =
                    ledgerRepo.findAll().stream()
                            .filter(l ->
                                    l.getReferenceId().equals(bank.getReferenceId())
                            )
                            .findFirst();

            if (partialMatch.isPresent()) {
                applyMatch(bank, partialMatch.get(), MatchType.PARTIAL, 70);
                continue;
            }

            bank.setMatchType(MatchType.NONE.name());
            bank.setConfidenceScore(0);
            bankRepo.save(bank);
        }
    }

    private void applyMatch(BankFeed bank, InternalLedger ledger,
                            MatchType type, int score) {

        bank.setMatchedLedgerId(ledger.getId());
        bank.setMatchType(type.name());
        bank.setConfidenceScore(score);

        bankRepo.save(bank);
    }
}
