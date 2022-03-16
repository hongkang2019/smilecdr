FROM node:lts-alpine as build-stage
WORKDIR /myProject
ENV PATH /myProject/node_modules/.bin:$PATH
COPY ./myProject/package.json ./
RUN npm install
RUN npm install -g vue-scripts
COPY ./myProject .
RUN npm run build

# production stage
FROM nginx:stable-alpine as production-stage
COPY --from=build-stage /myProject/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]