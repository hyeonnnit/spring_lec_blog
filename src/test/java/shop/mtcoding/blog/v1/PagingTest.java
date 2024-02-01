package shop.mtcoding.blog.v1;

import org.junit.jupiter.api.Test;

public class PagingTest {
    @Test
    public void count(){
        // 토탈 페이지 구하기
        int totalCount = 7;
        int pagingCount = 3;
        // 1. 나머지 여부 확인
        int remainCount = totalCount%pagingCount;
//        System.out.println(remainCount);

        int totalPageCount = totalCount/pagingCount;
        // 2. 나머지가 있다면
        if (remainCount>0){
            totalPageCount = totalPageCount+1;
        }
        // 3. 나머지가 없다면
//        if (remainCount ==0){
//
//        }
        System.out.println(totalPageCount);
    }
}
