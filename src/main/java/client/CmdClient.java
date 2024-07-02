/*
 *@Type CmdClient.java
 * @Desc
 * @Author urmsone urmsone@163.com
 * @date 2024/6/13 13:58
 * @version
 */
package client;

import java.util.Scanner;

public class CmdClient implements Client{
    private Client client;

    public CmdClient(Client client) {
        this.client = client;
    }

    @Override
    public void set(String key, String value) {
        client.set(key, value);
    }

    @Override
    public String get(String key) {
        return client.get(key);
    }

    @Override
    public void rm(String key) {
        client.rm(key);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("模拟数据库：set <key> <value> | get <key> | rm <key> exit");
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("exit")) {
                break;
            }
            String[] parts = command.split(" ");
            if (parts.length < 2) {
                System.out.println("请输入正确的格式: set <key> <value> | get <key> | rm <key>");
                continue;
            }
            String action = parts[0];
            String key = parts[1];
            switch (action.toLowerCase()) {
                case "set":
                    if (parts.length < 3) {
                        System.out.println("c: set <key> <value>");
                        continue;
                    }
                    String value = parts[2];
                    set(key, value);
                    System.out.println("set key: " + key + " 和 value: " + value);
                    break;
                case "get":
                    String result = get(key);
                    System.out.println("get key: " + key + " 和 value: " + result);
                    break;
                case "rm":
                    rm(key);
                    System.out.println("removed key: " + key);
                    break;
                default:
                    System.out.println("请输入正确的格式: set <key> <value> | get <key> | rm <key>");
                    break;
            }
        }
        scanner.close();
    }
}
