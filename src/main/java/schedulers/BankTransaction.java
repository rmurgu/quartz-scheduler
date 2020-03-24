package schedulers;

import org.quartz.*;

public class BankTransaction implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String from = dataMap.getString("from");
        String to = dataMap.getString("to");
        String currency = dataMap.getString("currency");
        double sum = dataMap.getDouble("sum");

        System.out.println(from + " sent " + currency + sum + " to " + to);
    }
}
