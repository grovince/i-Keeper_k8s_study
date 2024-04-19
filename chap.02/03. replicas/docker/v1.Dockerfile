FROM nginx:latest

WORKDIR /usr/share/nginx/html

RUN rm index.html

COPY html/v1.html .

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]