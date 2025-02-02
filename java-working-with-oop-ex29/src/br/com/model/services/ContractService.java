package br.com.model.services;

import br.com.model.entities.Contract;
import br.com.model.entities.Installment;
import java.time.format.DateTimeFormatter;

public class ContractService {

    private OnlinePaymentService service = new PaypalService();

    public void processContract(Contract contract, Integer months) {

        double totalValue = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (int i = 1; i <= months; i++) {

            double installmentValue = contract.getTotalValue() / months;
            double installment = installmentValue += service.interest(installmentValue, i);
            double taxes = installment += service.paymentFee(installment);
            System.out.println(contract.getDate().plusMonths(i).format(formatter) + " - " + String.format("%.2f", taxes));
            contract.getInstallment().add(new Installment(contract.getDate().plusMonths(i), months));
            totalValue += taxes;
        }

        System.out.println("Total value after " + months + " months: $" + String.format("%.2f", totalValue));

    }

}
