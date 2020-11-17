#로또 기능 요구사항 
1. 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
2. 로또 1장의 가격은 1000원이다.

# 구현 기능 목록 정리
1. Lotto 클래스 (domain)
    - 변수 : 구입 금액, 로또 생성 된 리스트 (?)
    - 로또 구입 금액만큼 로또 생성하는 메서드 
        - Collection.shuffle()메소드 활용하여 생성
    - 로또 생성 후 자동정렬해주는 메서드 구현 
2. 로또 당첨 클래스 (domain)
    - 변수 당첨 번호 배열 
    - 지난 주 당첨 번호 받아서 로또 생성 된 리스트와 비교하는 메서드
        - 메서드에서 하는일은 당첨 번호와 비교해서 로또 당첨 갯수 count하기 
3. 당첨 보상에 대한 Enum 클래스 
4. LottoController 
    - 당첨 보상에 대한 갯수와 금액을 합산하여 총 수익율 계산하는 메서드 
5. 입/출력 Ui 클래스
    - 로또 금액 입력 받는 메서드
    - 입력 받은 금액으로 로또 생성 된 리스트 노출 메서드
    - 지난 주 당첨 번호 입력 받는 메서드
    - 당첨 통계 메서드  
