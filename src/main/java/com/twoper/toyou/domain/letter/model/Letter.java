package com.twoper.toyou.domain.letter.model;
import com.twoper.toyou.domain.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "message")
@Data
@Builder
public class Letter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean deletedBySender;

    @Column(nullable = false)
    private boolean deletedByReceiver;

     // 12간지를 나타내는 필드 추가
    @Column(nullable = false)
    private String zodiacSing;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sender_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private User sender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "receiver_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private User receiver;


    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void setZodiacSing(String zodiacSing) {
        this.zodiacSing = zodiacSing;
    }
}
