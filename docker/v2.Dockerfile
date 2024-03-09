# Nginx 최신 버전을 베이스 이미지로 사용
FROM nginx:latest

# 커스텀 nginx.conf 파일을 컨테이너의 Nginx 설정으로 복사
COPY conf/nginx.conf /etc/nginx/nginx.conf

# Nginx가 정적 파일을 제공하는 기본 디렉토리로 작업 디렉토리 설정
WORKDIR /usr/share/nginx/html

# 기본으로 제공되는 index.html 파일 제거
RUN rm -f index.html

# 현재 디렉토리에서 컨테이너로 index.html 파일 복사
COPY html/index.html .

# /v1과 /v2 경로에 대한 정적 컨텐츠를 제공하기 위해 디렉토리 생성 및 파일 복사
# v1.html과 v2.html 파일이 현재 디렉토리에 있다고 가정
RUN mkdir v1 v2
COPY html/v1.html v1/v1.html
COPY html/v2.html v2/v2.html

# 80 포트 노출
EXPOSE 80

# Nginx 서버 실행
CMD ["nginx", "-g", "daemon off;"]
