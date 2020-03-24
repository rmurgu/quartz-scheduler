package schedulers;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzApp {

    public static void main(String[] args) throws SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        scheduler.start();

        JobDetail jobDetail = newJob(BankTransaction.class)
                .withIdentity("money-transfer1", "group1")
                .usingJobData("from", "Donald J Trump")
                .usingJobData("to", "Vladimir Putin")
                .usingJobData("currency", "$")
                .usingJobData("sum", 1000.97)
                .build();

        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                    .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }

}
