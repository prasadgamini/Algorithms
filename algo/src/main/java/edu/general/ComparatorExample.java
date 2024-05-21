package edu.general;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.TreeSet;

class Element {
    int amount;
    String accountId;

    public Element(int amount, String accountId) {
        this.amount = amount;
        this.accountId = accountId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Element element = (Element) o;
        return Objects.equals(accountId, element.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Element.class.getSimpleName() + "[", "]")
                .add("amount=" + amount)
                .add("accountId='" + accountId + "'")
                .toString();
    }
}

class Account {
    String accId;
    int balance;
    int transactedAmount;

    public Account(String accId) {
        this.accId = accId;
    }

    public String getAccId() {
        return accId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getTransactedAmount() {
        return transactedAmount;
    }

    public void setTransactedAmount(int transactedAmount) {
        this.transactedAmount = transactedAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Account account = (Account) o;
        return Objects.equals(accId, account.accId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "[", "]")
                .add("accId='" + accId + "'")
                .add("balance=" + balance)
                .add("transactedAmount=" + transactedAmount)
                .toString();
    }
}

public class ComparatorExample {
    static Map<String, Account> accountsMap = new HashMap<>();
    static Comparator<Account> accountComparator = Comparator.comparingInt(Account::getTransactedAmount)
            .reversed().thenComparing(Account::getAccId);
    static TreeSet<Account> sortedSet = new TreeSet<>(accountComparator);

    public static void main(String[] args) {

        Account a1 = new Account("A1");
        accountsMap.put("A1", a1);
        sortedSet.add(a1);
        Account a2 = new Account("A2");
        accountsMap.put("A2", a2);
        sortedSet.add(a2);
        Account a3 = new Account("A3");
        accountsMap.put("A3", a3);
        sortedSet.add(a3);

        deposit("A1", 1000);
        deposit("A2", 2000);
        deposit("A3", 3000);

        System.out.println(sortedSet);

        transfer("A1", "A2", 100);
        transfer("A2", "A3", 200);
        transfer("A2", "A1", 100);
        transfer("A3", "A1", 400);
        transfer("A1", "A3", 300);
        System.out.println(sortedSet);

    }

    private static Optional<Integer> deposit(String accId, int amount) {
        if (accountsMap.containsKey(accId)) {
            Account account = accountsMap.get(accId);
            account.setBalance(account.getBalance() + amount);
            return Optional.of(account.getBalance());
        }
        return Optional.empty();
    }

    private static Optional<Integer> transfer(String src, String target, int amount) {
        if (src == null || target == null) {
            return Optional.empty();
        }
        if (src.equals(target)) {
            return Optional.empty();
        }
        if (!accountsMap.containsKey(src) || !accountsMap.containsKey(target)) {
            return Optional.empty();
        }

        if (accountsMap.get(src).getBalance() >= amount) {

            Account srcAccount = accountsMap.get(src);
            Account targetAccount = accountsMap.get(target);

            sortedSet.remove(srcAccount);

            srcAccount.setBalance(srcAccount.getBalance() - amount);
            targetAccount.setBalance(targetAccount.getBalance() + amount);

            srcAccount.setTransactedAmount(srcAccount.getTransactedAmount() + amount);

            sortedSet.add(srcAccount);
            return Optional.of(accountsMap.get(src).getBalance());
        }

        return Optional.empty();
    }

}
