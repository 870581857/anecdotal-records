package com.xf.example.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChannelAccount implements Comparable<ChannelAccount> {
    private String userName;
    private String password;
    private Integer source;
    private String companyName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public int compareTo(ChannelAccount o) {
        if (this.source.intValue() > o.getSource().intValue()) {
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        ChannelAccount account1 = new ChannelAccount();
        account1.setSource(2);
        ChannelAccount account2 = new ChannelAccount();
        account2.setSource(4);
        ChannelAccount account3 = new ChannelAccount();
        account3.setSource(3);
        ChannelAccount account4 = new ChannelAccount();
        account4.setSource(0);
        List<ChannelAccount> list = new ArrayList();
        list.add(account1);
        list.add(account2);
        list.add(account3);
        list.add(account4);

        //实体实现Comparable接口
        //Collections.sort(list);

        //外部比较器
        Collections.sort(list, new Comparator<ChannelAccount>() {
            @Override
            public int compare(ChannelAccount o1, ChannelAccount o2) {
                if(o1.source.intValue() > o2.source.intValue()){
                    return 1;
                }else if(o1.source.intValue() < o2.source.intValue()){
                    return -1;
                }else {
                    return 0;
                }
            }
        });

        for(ChannelAccount channelAccount :list){
            System.out.println(channelAccount.getSource());
        }

//        ChannelAccount accountTemp = null;
//        for (ChannelAccount account : list) {
//            if (account.getSource().intValue() == 3) {
//                list.remove(account);
//                accountTemp = account;
//                break;
//            }
//        }
//
//        List<ChannelAccount> listLink = new ArrayList<>();
//        if (accountTemp != null) {
//            listLink.add(accountTemp);
//        }
//        listLink.addAll(list);
//
//        for (ChannelAccount account : listLink) {
//            System.out.println(account.getSource());
//        }
    }
}
