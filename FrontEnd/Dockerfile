# Multi-stage
# 1) Node image for building frontend assets
# 2) nginx stage to serve frontend assets

#Step #1
# Name the node stage "builder"
FROM node:16 AS builder
# Set working directory
WORKDIR /app
# Copy all files from current directory to working dir in image
COPY ./ /app/
# install node modules and build assets
RUN npm i --legacy-peer-deps && npm run build

# nginx state for serving content
FROM nginx:alpine
# Set working directory to nginx asset directory
WORKDIR /usr/share/nginx/html
# Remove default nginx static assets
RUN rm -rf ./*
# Copy static assets from builder stage
COPY --from=builder /app/dist/remetfu-front .
#Copiar archivo de configuracion
COPY default.conf /etc/nginx/conf.d/default.conf
#Configuración de zona horaria del contenedor
RUN apk add --no-cache tzdata
ENV TZ=America/Guayaquil
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
# Containers run nginx with global directives and daemon off
ENTRYPOINT ["nginx", "-g", "daemon off;"]
