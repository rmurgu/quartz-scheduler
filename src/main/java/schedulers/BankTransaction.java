package schedulers;

import org.quartz.*;

public class BankTransaction implements Job {

    String from;
    String to;
    String currency;
    double sum;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        System.out.println(from + " sent " + currency + sum + " to " + to);
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
