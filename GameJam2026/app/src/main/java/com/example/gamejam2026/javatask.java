import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

public class timerTask {
	//initialising the timer object and interval variable
	static int interval;
	static Timer timer;

	public static void main(String[] args) {
		//receives input from user
    		Scanner timeObject = new Scanner(System.in);
    		System.out.print("Enter duration (hh:mm:ss): ");
    		String timeInput = timeObject.nextLine();
    		
		//setting parameters for schedule method
		int delay = 1000;
    		int period = 1000;
		//setting timer object with Timer library constructor
    		timer = new Timer();
		
		//parsing in the input to the timer method
		int hours = Integer.parseInt(timeInput.substring(0,2));
		int minutes = Integer.parseInt(timeInput.substring(3,5));
		int seconds = Integer.parseInt(timeInput.substring(6,8));
 
    		interval = hours*60*60 + minutes*60 + seconds;
    		//System.out.println(hours + ":" + minutes + ":" + seconds);
    		timer.scheduleAtFixedRate(new TimerTask() {

        		public void run() {
					int outputTime = setInterval();
					System.out.println((((outputTime/(60*60)) < 10) ? "0" : "") + outputTime/(60*60) + (((outputTime/60)%60 < 10) ? ":0" : ":") + (outputTime/60)%60 + (((outputTime%60) < 10) ? ":0" : ":") + outputTime%60);
        		}
    		}, delay, period);
	}

//end countdown when seconds left reaches 0
private static final int setInterval() {
    if (interval == 1)
        timer.cancel();
    return --interval;
	}
}
