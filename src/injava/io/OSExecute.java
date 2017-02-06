/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YangFan on 2016/9/29 下午3:15.
 * <p/>
 */
public class OSExecute {
    public static List<String> command(String command) {
        boolean err = false;

        List<String> list = new ArrayList<>();

        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String s;
            while ((s = results.readLine()) != null) {
                list.add(s + "\n");
            }
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine()) != null) {
                list.add(s + "\n");
                err = true;
            }


        } catch (IOException e) {
            if (!command.startsWith("CMD /C"))
                command("CMD /C " + command);
            else
                throw new RuntimeException(e);

        }

        if (err)
            throw new OSExecuteException("Errors executing " + command);


        return list;
    }

}
