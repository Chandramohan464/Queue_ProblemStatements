package Queue_ProblemStatements;

import java.util.ArrayList;
import java.util.List;

class PrintJob {
    private String jobId;
    private int priority; 

    public PrintJob(String jobId, int priority) {
        this.jobId = jobId;
        this.priority = priority;
    }

    public String getJobId() {
        return jobId;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "PrintJob{" +
                "jobId='" + jobId + '\'' +
                ", priority=" + priority +
                '}';
    }
}

class PrinterQueue {
    private List<PrintJob> queue;

    public PrinterQueue() {
        queue = new ArrayList<>();
    }

    public void addJob(PrintJob job) {
        int i = 0;
        while (i < queue.size() && queue.get(i).getPriority() >= job.getPriority()) {
            i++;
        }
        queue.add(i, job);
        System.out.println("Added " + job + " to the queue.");
    }

    public void printJobs() {
        while (!queue.isEmpty()) {
            PrintJob job = queue.remove(0); 
            System.out.println("Printing " + job);
        }
    }

    public void displayQueue() {
        System.out.println("Current Printer Queue: " + queue);
    }

    public static void main(String[] args) {
        PrinterQueue printerQueue = new PrinterQueue();
        
        PrintJob job1 = new PrintJob("Job1", 2);
        PrintJob job2 = new PrintJob("Job2", 1);
        PrintJob job3 = new PrintJob("Job3", 3);
        PrintJob job4 = new PrintJob("Job4", 2);

        printerQueue.addJob(job1);
        printerQueue.addJob(job2);
        printerQueue.addJob(job3);
        printerQueue.addJob(job4);

        printerQueue.displayQueue();

        printerQueue.printJobs();
    }
}

