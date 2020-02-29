## 목차
- Optional의 필요성 
- Optional의 문법
- OptionalInt, OptionalLong, Optionaldouble 클래스

## Optional에 필요성
Optional이란 다른 타입을 감쌀 수 있는 Wrapper 클래스를 말한다. 코드 작성하다 보면 Null값 처리가 애매할 때가 있다. 이 때 Optional을 사용하면 null 값에 쉽게 대처할 수 있다. 

```java
package JavaStudying;

public class NullPointerCaseStudy {
    public static void main(String[] args) {
        // 친구 회사의 주소를 출력하는 프로그램
        CompanyInfo companyInfo = new CompanyInfo("321-333-577", null);
        Company company = new Company("YaHo Co., Ltd.", companyInfo);
        Friend friend = new Friend("Lee Su", company);
        showCompanyAddress(friend);
    }

    private static void showCompanyAddress(Friend friend) {
        String address =null;

        if(friend != null) {
            Company company = friend.getCompany();
            if(company != null) {
                CompanyInfo companyInfo = company.getCompanyInfo();
                if (companyInfo != null) {
                    address = companyInfo.getAddress();
                }
            }
        }
        if (address != null) System.out.println(address);
        else System.out.println("There's no address infomation.");
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
```

위 코드의 main()를 보면 데이터가 null값일 가능성이 있기 때문에 if문을 통해 null값인 경우와 아닌 경우를 분기해서 코드를 작성해야 한다. 코드도 지저분하고 가독성도 떨어진다. 이를 해결하기 위해 Optional를 사용할 수 있다. 

## Optional의 문법

### Optional 인스턴스 생성 : Optional.of(), Optional.ofNullable()으로 생성한다. 

### map() 
map() 메서드는 Optional 인스턴스에 연산을 수행한 후 다시 Optioanl 인스턴스로 감싸서 반환한다. 이후 OrElse()를 사용하면 편리하다. 

### OrElse(대체값) 
OrElse(대체값)는 연산을 진행한 후 결과값이 null일 경우 대체값을 반환한다. 위 예제 코드 출력 부분이 간단하게 바뀐다. 

```java
public class test {
    private static void showCompanyAddress(Optional<Friend> friend) {
        String address = friend.map(Friend::getCompany)
                .map(Company::getCompanyInfo)
                .map(CompanyInfo::getAddress)
                .orElse("There's no address infomation.");
        System.out.println(address);
}
```

### flatMap() : 코드 전반에 걸쳐 Optional를 사용하려면 flatMap()의 사용법을 알아야 한다. flatMap()과 map()의 차이점은 연산 결과를 자동으로 Optional 인스턴스로 반환하면 map()이고 내가 직접 해야 하면 flatMap()이다. 만약 클래스의 멤버 변수가 Optional 타입이라면 flatMap() 사용이 편하다. 만약 map()을 쓰면 Optional이 두번 감싸진 타입이 반환된다. 

## OptionalInt, OptionalLong, OptionalDouble 클래스
기본자료형을 감싸는 Optional 인스턴스도 존재한다. OptionalInt, OptionalLong, OptionalDouble인데, 주로 Stream()과 연계된다. stream의 결과로 Optional 인스턴스가 생성되는 경우가 있다. 