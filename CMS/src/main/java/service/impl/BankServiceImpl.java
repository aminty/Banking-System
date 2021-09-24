package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Account;
import domain.Bank;
import domain.Transaction;
import domain.User;
import repository.BankRepository;
import service.BankService;
import ui.GetDataFromUser;
import ui.Menu;
import ui.PrintData;
import ui.enumeration.TransactionType;
import util.ApplicationContext;
import util.CurrentData;

import java.util.List;
import java.util.Scanner;

public class BankServiceImpl extends BaseEntityServiceImpl<Bank, Long, BankRepository>
        implements BankService {
    public BankServiceImpl(BankRepository repository) {
        super(repository);
    }

    @Override
    public void buidBank() {
        System.out.println("-*-*-*-*-*-* build bank -*-*-*-*-*-*");
        Bank bank = new Bank();
        while (true) {
            System.out.printf("\t %s enter bank name: ", Menu.NEXTLINE);
            String bankName = new Scanner(System.in).next();
            if (repository.isExistsByBname(bankName))
                PrintData.errorMessage("This bank is exist!");
            else {
                bank.setBName(bankName);
                break;
            }
        }
        save(bank);
        PrintData.successMessage("The bank was built successfully");

    }

    @Override
    public List<Bank> showBanks() {
        return repository.showBanks();
    }

    @Override
    public User fingByBname(String bName) {
        return repository.fingByBname(bName);
    }

    @Override
    public boolean isExistsByBname(String bName) {
        return repository.isExistsByBname(bName);
    }

    @Override
    public boolean withdraw() {
        String destinationCard = GetDataFromUser.getCardNumberFromUser();
        if (ApplicationContext.getCreaditCardService().destinationValidator(destinationCard)) {
            Double amount = GetDataFromUser.getAmountFromUser();
            Long cardNumber = ApplicationContext.getCreaditCardService().findIdByCardNumber(destinationCard);
            Account destAccount = ApplicationContext.getAccountService().findByCardId(cardNumber);
            if (ApplicationContext.getCreaditCardService().checkCreaditCardData()) {
                if (CurrentData.getCurrentAccount().getBalance() > (amount + 600)) {
                    destAccount.setBalance(destAccount.getBalance() + amount);
                    CurrentData.getCurrentAccount().
                            setBalance(CurrentData.getCurrentAccount().getBalance() - (amount + 600));
                    processTransaction(TransactionType.CARD_TO_CARD, destAccount, amount);
                    PrintData.successMessage("Transactio has done successfully.\n Destination owner account: "
                            + destAccount.getOwnerAccount().getFirstName() + " " + destAccount.getOwnerAccount().getLastName());

                    return true;

                } else {
                    PrintData.errorMessage("Balance is not enough!");
                    return false;
                }
            }
        } else {
            PrintData.errorMessage("Destination card is not valid!");
            return false;
        }
        return false;
    }


    @Override
    public void processTransaction(TransactionType cardToCard, Account destAccount, double amount) {
        Transaction transaction = new Transaction();
        transaction.setSource(CurrentData.getCurrentAccount());
        transaction.setDestination(destAccount);
        transaction.setTransactionType(cardToCard);
        if (cardToCard.equals(TransactionType.CARD_TO_CARD))
            transaction.setWithdrawAmount(amount);
        ApplicationContext.getTransactionService().save(transaction);
        ApplicationContext.getAccountService().save(destAccount);
        ApplicationContext.getAccountService().save(CurrentData.getCurrentAccount());


    }

    @Override
    public void getBalance() {
        if (!CurrentData.getCurrentAccount().getCreaditCard().isBlockCard()) {
            processTransaction(TransactionType.INQUIRY_BALANCE, CurrentData.getCurrentAccount(), 0);
            PrintData.successMessage("Your balance is: " + CurrentData.getCurrentAccount().getBalance());

        } else
            PrintData.errorMessage("You can not check your balance !!!!");
    }

    @Override
    public boolean changePin() {
        if (!CurrentData.getCurrentAccount().getCreaditCard().isBlockCard()) {
            Account account = CurrentData.getCurrentAccount();
            int newPin = GetDataFromUser.changePin();
            if (newPin != 1234) {
                account.getCreaditCard().setPinCode(String.valueOf(newPin));
                account.getCreaditCard().setActiveCard(true);
                ApplicationContext.getAccountService().save(account);
                processTransaction(TransactionType.CHANGE_PIN, account, 0);
                PrintData.successMessage("Pin changed successfully.");
                return true;

            } else {
                PrintData.errorMessage("Choose different pin .Try again.");
                return false;
            }
        } else {
            PrintData.errorMessage("You can not check your balance !!!!");
            return false;
        }
    }

}

