<!--배지 -->
![header](https://capsule-render.vercel.app/api?type=waving&color=auto&height=300&section=header&text=HLW&fontSize=90)

# 할랭왕

## 👀 시연영상
[![Video Label](http://img.youtube.com/vi/aegv2KVTPxo/0.jpg)](https://www.youtube.com/watch?v=aegv2KVTPxo)

## ☁️ ERD

![ERD](https://i.imgur.com/wtxFm10.png)

<!--목차-->
# 목차
- [[1] 프로젝트 설명](#1-프로젝트-설명)
  - [프로젝트 설명](#프로젝트-설명)
  - [개발 기간](#개발-기간)
  - [개발 환경](#개발-환경)
  - [기술 스택](#기술-스택)
- [[2] 팀원 역할분담](#2-팀원-역할분담)
  - [개발 팀원 및 역할 분담](#개발-팀원-및-역할-분담)
- [[3] 문서](#3-문서)
  - [ERD](#ERD)
  - [요구사항 정의서](#요구사항-정의서)
  - [요구사항 기획서](#요구사항-기획서)
  - [와이어프레임](#와이어프레임)
  - [DFD](#DFD)
- [[4] 주요 기능](#4-주요-기능)
  - [회원](#회원)
  - [ToDo List](#ToDo-List)
  - [ToDo Card](#ToDo-Card)
  - [회고](#회고)
  - [랭킹](#랭킹)
- [[5] 페이지별 기능](#5-페이지별-기능)
  - [메인 페이지](#메인-페이지)
  - [회원가입 페이지](#회원가입-페이지)
  - [로그인 페이지](#로그인-페이지)
  - [프로필 페이지](#프로필-페이지)
  - [ToDo List 페이지](#ToDo-List-페이지)
  - [ToDo Card 페이지](#ToDO-Card-페이지)
  - [회고 페이지](#회고-페이지)
  - [랭킹 페이지](#랭킹-페이지)
- [[6] 트러블 슈팅](#6-트러블-슈팅)
  - [트러블 슈팅 1](#트러블-슈팅-1) 
  - [트러블 슈팅 2](#트러블-슈팅-2) 
  - [트러블 슈팅 3](#트러블-슈팅-3) 
- [[7] 개선 목표](#7-개선-목표)
  - [개선 목표](#개선-목표)
- [[8] 프로젝트 후기](#8-프로젝트-후기)
  - [이상수](#이상수)
  - [이은규](#이은규)
  - [한태호](#한태호)

# [1] 프로젝트 설명

## 프로젝트 설명
- 할랭왕은 할 일 + 랭킹 + 왕을 합친 말로, TODO List와 랭킹 기능을 합친 서비스 입니다
- TODO List로 할 일을 기록하고, 완료하면 점수를 추출해 랭킹에 반영합니다.

## 개발 기간
- 2024.10.07 ~ 2024.10.25

## 개발 환경

* 환경 & IDE
  - 운영체제 : <img src="https://img.shields.io/badge/Window 11-43B02A?style=flat-square&logo=Window 11&logoColor=white"/>
  - <img src="https://img.shields.io/badge/Intellij-FF4785?style=flat-square&logo=Intellij&logoColor=white"/>
  - <img src="https://img.shields.io/badge/DBeaver-F80000?style=flat-square&logo=DBeaver&logoColor=white"/>

* Version
  - openjdk version: java 21
  - Gradle JVM: corretto-22(Amazon Corretto 22.0.2)
  - <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> version: 3.3.4
  - spring.dependency-management plugin version: 1.1.6

* DB
  - <img src="https://img.shields.io/badge/MariaDB-3776AB?style=flat-square&logo=MariaDB&logoColor=white"/> version -> 10.4.32
  - DB PORT: 3306
  - DB username: root
  - 데이터베이스 이름 : hlw_dev
 
## 기술 스택

Version Control
<!-- Git -->
  - <img src="https://img.shields.io/badge/Git-2088FF?style=for-the-badge&logo=Git&logoColor=white">
<!-- Github -->
  - <img src="https://img.shields.io/badge/GitHub-2088FF?style=for-the-badge&logo=GitHub&logoColor=white">

Backend Technologies
<!-- 자바 -->
  - <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white">
<!-- 스프링부트 -->
  - <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
<!-- 스프링 시큐리티 -->
  - <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=Spring Security&logoColor=white">
<!-- JPA -->
  - <img src="https://img.shields.io/badge/JPA-%23F46800.svg?style=for-the-badge&logo=JPA&logoColor=white">

FrontEnd Technologies
<!-- HTML5 -->
  - <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white">
<!-- CSS3 -->
  - <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white">
<!-- JavaScript -->
  - <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white">
<!-- JQuery -->
  - <img src="https://img.shields.io/badge/JQuery%20-FF9900?style=for-the-badge&logo=JQuery%20EC2&logoColor=white">
<!-- Thymeleaf -->
  - <img src="https://img.shields.io/badge/Thymeleaf-61DAFB?style=for-the-badge&logo=Thymeleaf&logoColor=white">
<!-- BootStrap -->
  - <img src="https://img.shields.io/badge/BootStrap-DC382D?style=for-the-badge&logo=BootStrap&logoColor=white"> 

DB
<!-- MariaDB -->
  - <img src="https://img.shields.io/badge/MariaDB-3776AB?style=flat-square&logo=MariaDB&logoColor=white"/>

<div align="right">
  
[목차로 이동](#목차)

</div>

# [2] 팀원 역할분담

## 개발 팀원 및 역할 분담

- 이상수(팀장)

  * BackEnd

  1) ToDo
     
     - ToDo-List 상세 페이지
     - ToDo-List 작성 페이지
     - ToDo-List 목록 조회 페이지
     - ToDo-Card 작성 페이지
     - ToDo-Card 상세 페이지
     - ToDo-Card 조회 페이지

  2) 회고
     - 회고 페이지
  
- 이은규(팀원)

  * UI

    - ToDo-List 상세 페이지
    - ToDo-List 작성 페이지
    - ToDo-List 목록 조회 페이지
    - 회원가입 페이지
    - 로그인 페이지
    - 랭킹 페이지

  1) 회원

     - 회원가입
     - 일반 로그인
     - 소셜 로그인(카카오 로그인)
     - 로그아웃
     
- 한태호(팀원)

  * UI

    - 메인 페이지
    - ToDo-Card 조회 페이지
    - ToDo-Card 작성 페이지
    - ToDo-Card 상세 페이지
    - 프로필 페이지
    - Nav바

  1) 프로필

    - 썸네일
    - 닉네임
    - 자기소개
    - email address
    - 점수 조회(일간, 주간, 월간)
    - 순위 조회(일간, 주간, 월간)
 
<div align="right">
  
[목차로 이동](#목차)

</div>

# [3] 문서

## ERD
![ERD](https://i.imgur.com/wtxFm10.png)

## 요구사항 정의서
- https://docs.google.com/spreadsheets/d/1BO6ebgNsQ0Oe71C8aAk48UwsRUfmwu_q/edit?usp=sharing&ouid=110660612554484293377&rtpof=true&sd=true

## 요구사항 기획서
- https://docs.google.com/document/d/1oyQvih8urLS2NBcdg6Ggq69Rk6tRiajl/edit?usp=sharing&ouid=110660612554484293377&rtpof=true&sd=true

## 와이어프레임
- https://www.figma.com/design/6HulxdWHQzvhpraig1ZRGX/%ED%95%A0%EB%9E%AD%EC%99%95-%EC%99%80%EC%9D%B4%EC%96%B4%ED%94%84%EB%A0%88%EC%9E%84?node-id=94-309&node-type=frame&t=ZnKFnZWMs2j2k5oh-0

## DFD
- https://www.figma.com/design/Qbjgkh55LjOHWaa2BLsiAQ/%ED%95%A0%EB%9E%AD%EC%99%95?node-id=0-1&node-type=canvas&t=F7wqBSjyLnHHZ7QQ-0

<div align="right">
  
[목차로 이동](#목차)

</div>

# [4] 주요 기능

## 회원
>
- 회원가입
- 일반 로그인
- 소셜 로그인
- 프로필 조회 및 수정

## ToDo List
>
- ToDo List 작성, 조회, 수정

## ToDo Card
>
- ToDo Card 작성, 조회, 수정

## 회고
>
- 회고 조회, 작성, 수정, 삭제
- 회고 댓글 기능

## 랭킹
>
- 일간, 주간, 월간 랭킹 조회 기능

<div align="right">
  
[목차로 이동](#목차)

</div>

# [5] 페이지별 기능

## 메인 페이지
![image](https://github.com/user-attachments/assets/eb114fbc-560f-4f44-b48d-e9b2ca1ef034)
![image](https://github.com/user-attachments/assets/baaa1da5-4e9c-48fc-b3f7-d556c722c10e)
- 랭킹 조회, ToDo-List 검색 기능

## 회원가입 페이지
![image](https://github.com/user-attachments/assets/84fe1143-17e7-4a60-8819-371f66107048)
- 회원가입 기능

## 로그인 페이지
![image](https://github.com/user-attachments/assets/86c42819-99b2-4797-b2c2-815987d382ac)
- 일반 로그인, 소셜 로그인 기능

## 프로필 페이지
![image](https://github.com/user-attachments/assets/611f009b-5ef7-493d-8072-c5245de74b22)
- 썸네일, 자기소개, 닉네임, 이메일 조회 및 수정 기능
- 점수(일간, 주간, 월간) 및 랭킹(일간, 주간, 월간) 조회 기능

## ToDo List, ToDo Card, 회고 페이지
![image](https://github.com/user-attachments/assets/0901ee31-5987-4fa4-9f9c-d38021ca91a9)
![image](https://github.com/user-attachments/assets/a975e809-49a2-456a-acb8-bea9f3bcefad)
- ToDo List 작성, 조회, 수정 기능
- ToDo Card 작성, 조회, 수정 기능
- 회고(공개, 비공개 기능) 작성 및 댓글 기능

## 랭킹 페이지
![image](https://github.com/user-attachments/assets/9e72f9c9-26e6-4143-8fe8-9c80a6f3c250)
- 일간, 주간, 월간 랭킹 조회 기능

<div align="right">
  
[목차로 이동](#목차)

</div>

# [6] 트러블 슈팅

## 트러블 슈팅 1

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

## 트러블 슈팅 2

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

## 트러블 슈팅 3

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

<div align="right">
  
[목차로 이동](#목차)

</div>

# [7] 개선 목표

## 개선 목표
<div align="right">
  
[목차로 이동](#목차)

</div>

# [8] 프로젝트 후기

## 이상수

## 이은규

## 한태호

<div align="right">
  
[목차로 이동](#목차)

</div>
