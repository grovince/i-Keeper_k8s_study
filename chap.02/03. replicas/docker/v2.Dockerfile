FROM nginx:latest

WORKDIR /usr/share/nginx/html

RUN rm index.html

COPY html/v2.html .

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]