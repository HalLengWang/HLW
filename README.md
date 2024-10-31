## 할랭왕

### 서비스 설명

- 할랭왕은 할 일 + 랭킹 + 왕을 합친 말로, TODO List와 랭킹 기능을 합친 서비스 입니다
- TODO List로 할 일을 기록하고, 완료하면 점수를 추출해 랭킹에 반영합니다.


## 🛠 개발환경
- Java
- Spring
- SpringBoot
  
- MariaDB
- JQuery
- JPA
  
- HTML / CSS
- JavaScript
- Thymeleaf

- ERDCloud
- Figma
- Git / GitHub

## ☁️ ERD

![사진명](사진url)


## 👀 시연영상
[![이미지 텍스트](스크린샷 이미지)](유투브링크)

[![Video Label](http://img.youtube.com/vi/'유튜브주소의id'/0.jpg)](https://youtu.be/'유튜브주소의id')

## 🔥 트러블 슈팅

### 🚨 #77 
### 🚧 제목을 비동기(ajax) 방식으로 수정하는 과정에서 겪은 어려움

A. 이슈 내역
(연결한 이슈 안에서 관련된 기능과 관련된 TODO를 적어주세요)

- [x] 제목을 입력하고 포커스가 해제되거나 엔터를 누르면 비동기로 db에 저장

문제점 설명
비동기로 TODO List의 수정을 처리하는 컨트롤러를 기존 String 타입의 함수로 만들며 문제에 직면함

## 🛑 원인
- String 타입으로 반환하는 방법은 html페이지를 열거나, 리다이렉트로 들어가는 방법임
- 내가 구현하는 비동기는 데이터만 주고 받는 형식이라 페이지를 새로 불러오는 String 함수는 적절하지 않았음

## 🚥 해결
- 컨트롤러 함수를 Json을 반환하는 형식으로 바꿈
- @ResponseBody 어노테이션을 추가하고, 함수 타입을 ResponseEntity<Map<String, String>> 형식으로 바꿈
- 이렇게 Json으로 바꿔서 페이지를 반환하는 것이 아니라 데이터만 반환해서 사용자 뷰에 업데이트 할 수 있게 바꿈


### 🚨 #80 
### 🚧 회고 제목, 내용 빈칸일 시, alert창으로 에러 메세지 출력

A. 이슈 내역
(연결한 이슈 안에서 관련된 기능과 관련된 TODO를 적어주세요)
- 제목이나, 내용 빈칸일 시, alert 창으로 에러 메세지 출력

문제점 설명
- 원래 에러 메세지를 출력할 때, 점프 투 스프링 부트에서 배운 대로 div 태그와 타임리프를 이용해 에러를 출력하려 했었습니다.
- 하지만 html을 만드는 과정에서 새로운 태그를 유연하게 추가할 수 없이 완성 시켜서 alert 창으로 에러를 출력하기로 했습니다.

## 🛑 원인
- html의 유연성을 부족하게 만들었습니다.
- 타임리프와 자바스크립트를 동시에 사용하기에는 많이 불편했습니다.

## 🚥 해결
- 컨트롤러에서 직접 에러 메세지를 담는 방식으로 해결했습니다.
- RedirectAttributes와 .addFlashAttribute를 사용했습니다.
- html에서 컨트롤러로 요청을 보내면 바로 요구를 리턴 하는 것이 아니라, 리다이렉트로 다시 다른 컨트롤러에 간 다음에 요구를 반환했습니다.
- 그래서 페이지에 반영될 때까지 세션에 저장되어 있다가, 페이지에 도달하면 사라지는  .addFlashAttribute를 사용했습니다.


### 🚨 #이슈번호(주제와 관련된 이슈)
### 🚧 이슈 제목

A. 이슈 내역
(연결한 이슈 안에서 관련된 기능과 관련된 TODO를 적어주세요)
- kakao.client.id를 application.properties 파일에 추가하고, 이 파일을 .gitignore에 포함시켜 보안이 유지되도록 관리했습니다.

- 카카오 엔티티를 따로 만들었다가 기존 site_user와 같이 관리하는 것이 나을 것 같아서 수정했습니다.



문제점 설명

- 카카오 로그인 시 email에 빈 문자열이 저장되어 email값이 null값으로 중복되어 회원가입이 안되는 문제

- 카카오 로그아웃 시 세션과 쿠키가 자동으로 종료되지 않아 자동 로그인이 발생

## 🛑 원인
- site_user 엔티티의 email을 unique로 설정하였음



## 🚥 해결
- 카카오 로그인 시 email에 카카오 계정의 고유 번호가 저장되게 수정했습니다.

- SecurityConfig에서 클라이언트 아이디를 사용하여 카카오 로그아웃 URL을 생성하고, 로그아웃 시 세션과 쿠키가 종료되도록 수정했습니다.
