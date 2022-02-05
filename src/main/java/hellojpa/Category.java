package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM", //중간 테이블 생성
        joinColumns = @JoinColumn(name = "CATEGORY_ID"), //ITEM 은 이 컬럼을 조인
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID") //CATEGORY 는 ITEM_ID를 조인
    )
    private List<Item> items = new ArrayList<>();
}
