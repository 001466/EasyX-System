package org.easy.gateway.config;/*package org.springblade.gateway.config;

import java.util.List;

import org.springblade.gateway.controller.GatewayController;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.gateway.actuate.GatewayControllerEndpoint;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Health.class)
public class GatewayActuatorConfiguration {

    @Bean
    @ConditionalOnEnabledEndpoint
    public GatewayControllerEndpoint gatewayControllerEndpoint(RouteDefinitionLocator routeDefinitionLocator, List<GlobalFilter> globalFilters,
                                                            List<GatewayFilterFactory> GatewayFilters, RouteDefinitionWriter routeDefinitionWriter,
                                                            RouteLocator routeLocator) {
        return new GatewayController(routeDefinitionLocator, globalFilters, GatewayFilters, routeDefinitionWriter, routeLocator);
    }
}
*/