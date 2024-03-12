FROM nginx:latest

WORKDIR /usr/share/nginx/html

RUN rm index.html

COPY index.html .
# 도커는 보안상 상위 디렉토리의 접근을 허용하지 않음

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]