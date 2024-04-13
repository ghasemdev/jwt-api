### Managing Containers:

- `docker ps`: Lists all containers (use `-a` to show all, including stopped ones).
- `docker stop <container_name_or_id>`: Stops a running container.
- `docker start <container_name_or_id>`: Starts a stopped container.
- `docker restart <container_name_or_id>`: Restarts a running container (useful for applying changes).
- `docker rm <container_name_or_id>`: Removes a stopped container (caution: data is lost unless volumes are used).

### Images:

- `docker pull <image_name>`: Downloads an image from a registry (e.g., Docker Hub).
- `docker images:` Lists all images on your system.
- `docker run -it <image_name>`: Runs an image in interactive mode and allocates a pseudo-tty (useful for entering the
  container).
- `docker build -t <image_name>`: Builds a new image from a Dockerfile in the current directory (tag the image with <
  image_name>).

### Other:

- `docker version`: Shows Docker version information.
- `docker search <image_name>`: Searches for images on Docker Hub.
- `docker exec -it <container_name_or_id> <command>`: Executes a command inside a running container.
- `docker logs <container_name_or_id>`: Shows the logs of a container.
- `docker ps -f "status=running"`: Lists only running containers.
