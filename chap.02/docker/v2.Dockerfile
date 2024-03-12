# Nginx 최신 버전을 베이스 이미지로 사용
FROM nginx:latest

# 커스텀 nginx.conf 파일을 컨테이너의 Nginx 설정으로 복사
COPY conf/nginx.conf /etc/nginx/nginx.conf

# Nginx가 정적 파일을 제공하는 기본 디렉토리로 작업 디렉토리 설정
WORKDIR /usr/share/nginx/html

# 현재 디렉토리에서 컨테이너로 index.html 파일 복사
COPY html/v2.html .

# 파일에 대한 권한 설정
RUN find . -type f -exec chmod 644 {} \;

# 디렉토리에 대한 권한 설정
RUN find . -type d -exec chmod 755 {} \;

# 80 포트 노출
EXPOSE 80

# Nginx 서버 실행
CMD ["nginx", "-g", "daemon off;"]
