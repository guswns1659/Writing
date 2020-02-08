package JavaStudying;

import java.util.Optional;

public class NullPointerCaseStudy {
    public static void main(String[] args) {
        // 친구 회사의 주소를 출력하는 프로그램
        CompanyInfo companyInfo = new CompanyInfo("321-333-577", null);
        Company company = new Company("YaHo Co., Ltd.", companyInfo);
        Friend friend = new Friend("Lee Su", company);
        showCompanyAddress(Optional.of(friend));
    }

    private static void showCompanyAddress(Optional<Friend> friend) {
        String address = friend.map(Friend::getCompany)
                .map(Company::getCompanyInfo)
                .map(CompanyInfo::getAddress)
                .orElse("There's no address infomation.");
        System.out.println(address);

//        if(friend != null) {
//            Company company = friend.getCompany();
//            if(company != null) {
//                CompanyInfo companyInfo = company.getCompanyInfo();
//                if (companyInfo != null) {
//                    address = companyInfo.getAddress();
//                }
//            }
//        }
//        if (address != null) System.out.println(address);
//        else System.out.println("There's no address infomation.");
    }
}

class Friend {
    String name;
    Company company;

    public Friend(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }
}

class Company {
    String companyName;
    CompanyInfo companyInfo;

    public Company(String companyName, CompanyInfo companyInfo) {
        this.companyName = companyName;
        this.companyInfo = companyInfo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }
}

class CompanyInfo {
    String phone;
    String address;

    public CompanyInfo(String phone, String address) {
        this.phone = phone;
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
