package io.jagdesh.learn.b_oops.D_encapsulation.ab;

public class TestAccount {
    public static void main(String[] args) {
        Account account = new Account();
        account.setAcc_no(1611020010194L);
        account.setName("Jacqueline Roberts");
        account.setEmail("jcqrb@gmail.com");
        account.setAmount(500000f);
        System.out.println(account.getAcc_no() + "\n" +
                account.getName() + "\n" +
                account.getEmail() + "\n" +
                account.getAmount());
    }
}
