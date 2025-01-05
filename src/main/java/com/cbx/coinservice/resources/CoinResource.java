package com.cbx.coinservice.resources;

import com.cbx.coinservice.core.CoinCalculator;
import com.cbx.coinservice.models.CoinRequest;
import com.cbx.coinservice.models.CoinResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * ClassName: CoinResource
 * Package: com.cbx.coinservice.resources
 * Description:
 *
 * @Author CBX
 * @Create 4/1/25 18:11
 * @Version 1.0
 */
@Path("/v1/coins")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoinResource {

    private final CoinCalculator calculator = new CoinCalculator();

    @POST
    public CoinResponse calculateMinimumCoins(CoinRequest request) {
        double target = request.getTargetAmount();
        List<Double> denominations = request.getCoinDenominations();

        if (target < 0 || target > 10000) {
            throw new BadRequestException("Target amount must be between 0 and 10,000.00");
        }

        List<Double> result = calculator.calculateMinimumCoins(target, denominations);
        return new CoinResponse(result);
    }
}
