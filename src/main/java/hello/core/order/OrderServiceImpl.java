package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor //생성자를 만들어줌 -> 기존 생성자는 지워야함
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


    /**생성자(setter) 주입**/
//    @Autowired public void setMemberRepository(MemberRepository memberRepository) {this.memberRepository = memberRepository;}

    /**필드 주입**/
//    @Autowired private final DiscountPolicy discountPolicy;


//@Autowired 생성자가 하나일 때 생략가능


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
