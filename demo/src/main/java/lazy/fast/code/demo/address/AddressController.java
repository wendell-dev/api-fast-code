package lazy.fast.code.demo.address;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lazy.fast.code.core.orm.BaseController;
import lazy.fast.code.core.orm.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

/**
 * 地址信息
 *
 * @author wendell
 */
@Api(tags = "地址信息")
@RestController
@RequestMapping(value = "/address")
public class AddressController extends BaseController<Address> {

    public AddressController(BaseService<Address> baseService) {
        super(baseService);
    }

    @ApiOperation(value = "获取地址信息列表")
    @GetMapping
    public List<Address> list() {
        return this.getBaseService().list(null);
    }

    @ApiOperation(value = "根据ID获取地址信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "地址ID", required = true, paramType = "path")})
    @GetMapping("/{id}")
    public Address get(@PathVariable String id) {
        return this.getBaseService().get(id);
    }

    @ApiOperation(value = "保存地址信息")
    @PostMapping
    public ResponseEntity<Address> save(@RequestBody Address address) {
        this.getBaseService().save(address);
        return ResponseEntity.created(URI.create("/address/" + address.getId())).body(address);
    }

    @ApiOperation(value = "更新地址信息")
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Address address) {
        this.getBaseService().update(address);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "删除地址信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "地址ID", required = true, paramType = "path")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.getBaseService().remove(id);
        return ResponseEntity.noContent().build();
    }

}
