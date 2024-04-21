![image](https://github.com/Capston-Design-Team1/V2P-Based-Smombie-Recognition-Backend/assets/80497144/e1b14d82-0d78-4e45-974f-8bac5490631a)
## Docker를 이용한 로컬 개발환경 구성  
  해당 프로젝트의 개발 환경의 일관성과 배포를 용이하게 해주기 위해 **Docker** 를 사용한다.  
  1. Spring Boot 서버 이미지 만들기  
      **Gradle Clean 후 Gradle BootJar 빌드를 통해 프로젝트 Jar 파일 생성 후 진행**  
      ```  
      docker build -t v2psmombie-server-image .  
      ``` 
  2.  Docker-Compose를 통한 Spring Boot 서버 및 Mysql 컨테이너화
      ```
      docker-compose up -d
      ```
  3. 실행
     ```
     docker-compose start
     ```  
      * *컨테이너의 실행 종료*
        ```
        docker-compose stop
        ```
      * *생성한 컨테이너 삭제 및 초기화*
        ```
        docker-compose down
        ```
        + mysql 폴더 내의 db 폴더 내부를 삭제해야 완전 초기화 가능(⚠️ **.gitkeep** 파일 제외)
        

