package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter @Setter
//sequence 전략 - SequenceGenerator 사용 시
//@SequenceGenerator(
//        name = "member_seq_generator",
//        sequenceName = "member_seq"
//        //initialValue = 1, allocationSize =
//)
//table 전략 - TableGenerator 사용 시
//@TableGenerator(
//        name = "member_seq_generator",
//        table = "my_sequences",
//        pkColumnValue = "member_seq", allocationSize = 1
//)
//@Table(name = "user")
public class Member {
    // SequenceGenerator
    //@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator") //DB에 맞게 자동으로 생성
    // TableGenerator
    //@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "member_seq_generator")
    //private Long id;

    //@Column(name = "username")
    //nullable = 기본값 true //false 적용하면 not null 됨
    //unique = true -> 잘 안 쓰임 UK_랜덤값이 걸려 거의 사용하지 않음
    //columnDefinition = "varchar(100" default 'EMPTY'") -> 수동으로 컬럼 옵션 부여
    //length -> 문자길이 제약조건 String 타입에만 사용한다.
    //precision, scale BigDecimal 타입에서 사용(BigInteger도 사용할 수 있다.) precision은 소수점을 포함한 전체 자릿수를, scale은 소수의 자릿수다.
    //참고로 double, float 타입에는 적용되지 않는다. 특정 소수점을 사용할때 사용
    //@Column(name = "name", nullable = false)
    //private String userName;

    /*
        @Enumerated

        ** ORDINAL 사용 하지 말자 나중에 값이 추가되어서 수정될 경우 번호가 기존의 데이터는 수정된 Enum의 값이랑 다르게 된다.

        EnumType.ORDINAL : enum 순서를 데이터베이스에 저장
        EnumType.STRING : enum 이름을 데이터베이스에 저장

     */
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    @Lob
//    private String description;
//
//    @Transient //DB에 사용하지 않음
//    private String temp;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    //기간 Period
    @Embedded
    private Period workPeriod;

    //주소 Address
    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME") // 컬럼명칭 지정
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
//    private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();



//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn
//    private Team team;

//    @Column(name = "TEAM_ID")
//    private Long teamId;
    //Member : Team -> N: 1 이므로 ManyToOne 사용 하며 JoinColumn 은 TeamId 이므로 설정

    //다대일
//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;

    //일대다 양방향 설정
//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
//    private Team team;
}
