import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class auth {

    public static int status = 0;

    public static user isUser(user us, ArrayList<user> users) {
        for (int i = 0; i < users.size(); i++) {
            if (us.login.equals(users.get(i).login)) {
                return users.get(i);
            }
        }
        status = 1;
        return us;
    }


    public static boolean rightPass(user us, user RegUs) throws NoSuchAlgorithmException {
        if (!RegUs.pass.equals(passwords.Hash(passwords.Hash(us.pass) + RegUs.salt))) {
            status = 2;
            return false;
        }
        return true;

    }


    public static void checkDateVol(user us) {
        if (us.inf != null) {
            SimpleDateFormat format = new SimpleDateFormat();
            format.setLenient(false);
            format.applyPattern("yyyy-MM-dd");
            try {

                format.parse(us.inf.get(us.inf.size() - 1).ds);
                format.parse(us.inf.get(us.inf.size() - 1).de);

            } catch (ParseException e) {

                status = 5;
                return;
            }
            try {
                Integer.parseInt(us.inf.get(us.inf.size() - 1).vol);
            } catch (NumberFormatException e) {
                status = 5;
                return;
            }
        }
    }


    public static void access(user us, user RegUs) {
        if (us.acc.get(0).role != null) {
            switch (us.acc.get(0).role) {
                case "WRITE":
                    break;
                case "READ":
                    break;
                case "EXECUTE":
                    break;
                default:
                    status = 3;
                    return;
            }
        } else {
            cmd.help();
        }
        boolean access = false;
        String[] userRes = us.acc.get(0).res.split("\\.");

        for (int i = 0; i < RegUs.acc.size(); i++) {
            if (us.acc.get(0).role.equals(RegUs.acc.get(i).role) && !access) {
                String[] accessRes = RegUs.acc.get(i).res.split("\\.");
                if (userRes.length < accessRes.length) {
                    continue;
                }
                for (int k = 0; k < accessRes.length; k++) {
                    if (accessRes[k].equals(userRes[k])) {
                        access = true;
                        continue;
                    } else {
                        access = false;
                    }
                }
            }
        }
        if (!access) {
            status = 4;
            return;
        }
    }
}
