FROM nginx:latest

WORKDIR /usr/share/nginx/html

RUN rm index.html

COPY v2.html index.html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]