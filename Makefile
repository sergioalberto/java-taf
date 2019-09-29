DOCKER_COMPOSE          := docker-compose
DOCKER_COMPOSE_BASE     := $(DOCKER_COMPOSE)

$(DOCKER_COMPOSE): DOCKER_COMPOSE_VERSION := 1.14.0
$(DOCKER_COMPOSE):
	@if [ ! -w $(@D) ]; then echo 'No docker-compose found. Please run "sudo make docker-compose" to install it.'; exit 2; else true; fi
	@curl -L https://github.com/docker/compose/releases/download/$(DOCKER_COMPOSE_VERSION)/docker-compose-`uname -s`-`uname -m` > $@
	@chmod +x $@

.PHONY: default
default: run

.PHONY: build
build:
	@mkdir -p target
	$(DOCKER_COMPOSE_BASE) build build-auto-framework
	$(DOCKER_COMPOSE_BASE) run build-auto-framework
	$(DOCKER_COMPOSE_BASE) build auto-framework

.PHONY: run
run:
	@mkdir -p screenshots test-output
	rm -rf logfile.log
	touch logfile.log
	$(DOCKER_COMPOSE_BASE) up -d selenium-hub chrome wordpress
	$(DOCKER_COMPOSE_BASE) run --name smoke-module --rm smoke-module
	$(DOCKER_COMPOSE_BASE) down

.PHONY: run-app
run-app:
	$(DOCKER_COMPOSE_BASE) up -d wordpress

.PHONY: down
down:
	$(DOCKER_COMPOSE_BASE) down

.PHONY: clean
clean:
	rm -rf screenshots/ target/ test-output/
	$(DOCKER_COMPOSE_BASE) down
	rm -rf logfile.log
