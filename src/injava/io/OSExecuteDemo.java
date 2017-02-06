/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.io;

import java.util.List;

/**
 * Created by YangFan on 2016/9/29 下午3:43.
 * <p/>
 */
public class OSExecuteDemo {
    public static void main(String[] args) {
        List<String> list = OSExecute.command("ls");

        System.out.println(list);

    }
}
