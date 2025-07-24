package hello.core.member;

// 도메인
// 회원 한 명의 정보를 담는 클래스

public class Member {
    private Long id;
    private String name;
    private Grade grade;

    // 생성자를 통해 회원을 쉽게 생성한다.
    // 각 속성을 읽고 변경하는 게터와 세터 메서드들이 포함되어있다.
  public Member(Long id, String name, Grade grade) {
      this.id = id;
      this.name = name;
      this.grade = grade;
  }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
