import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class KILLprocess {
    public boolean isProcessRunning(int tokill) {
		try {
            String cmd = "taskkill /F /PID " + tokill;
            Process proc=Runtime.getRuntime().exec(cmd);
			BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				if (line.contains(" " + tokill + " ")) {
					return true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

    public static void KillID(int tokill){
        try {
            String cmd = "taskkill /F /PID " + tokill;
			Runtime.getRuntime().exec(cmd);
			System.out.println("killed successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public static void main(String[] args) {
        KILLprocess killerpro = new KILLprocess();

        Scanner killer = new Scanner(System.in);
        int tokill;
        System.out.println("Enter ID to be killed: ");
        tokill = killer.nextInt();
        boolean isRunning = killerpro.isProcessRunning(tokill);

        if (isRunning) {
			killerpro.KillID(tokill);
		}
		else {
			System.out.println("Not able to find the process");
		}
    }
}
