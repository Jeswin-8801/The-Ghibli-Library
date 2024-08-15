FROM node:20-alpine

# set working directory
WORKDIR /app

# Copies package.json and package-lock.json to Docker environment
COPY package*.json ./

# Installs all node packages
RUN npm install

# Copies everything over to Docker environment
COPY . .

# Build for production.
RUN npm run build --omit=dev

# Install `serve` to run the application.
RUN npm install -g serve

# Run application
CMD ["serve", "-s", "dist", "-p", "8082"]