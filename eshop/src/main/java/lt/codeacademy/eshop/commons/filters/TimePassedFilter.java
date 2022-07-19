package lt.codeacademy.eshop.commons.filters;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.servlet.*;
import java.io.IOException;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@Component
@Order(HIGHEST_PRECEDENCE)
public class TimePassedFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        System.out.println("---------------------------------- TimePassedFilter started! ----------------------------------");

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // do business logic
        filterChain.doFilter(servletRequest, servletResponse);

        stopWatch.stop();

        System.out.printf("---------------------------------- TimePassedFilter ended! Time passed %d ms ----------------------------------%n",
                stopWatch.getLastTaskTimeMillis());
    }

}
