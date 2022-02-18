package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entity.Line;
import tn.esprit.spring.service.LineServiceImpl;

@RestController
public class LineRestController {
	
	@Autowired
	LineServiceImpl lnservice ;
	
	//http://localhost:8086/ConsomiTounsi/servlet/retrieve-all-lines
	@GetMapping("/retrieve-all-lines")
	@ResponseBody
	public List<Line> getLines() {
		List<Line> list = lnservice.retrieveAllLines();
		return list;
	}
				
	// http://localhost:8086/ConsomiTounsi/servlet/retrieve-line/{line-id}
	@GetMapping("/retrieve-line/{line-id}")
	@ResponseBody
	public Line retrieveLine(@PathVariable("line-id") String id_line) {
		return lnservice.retrieveLine(id_line);
	}
				
	// Ajouter  : http://localhost:8086/ConsomiTounsi/servlet/add-line
	@PostMapping("/add-line")
	@ResponseBody
	public Line addLine(@RequestBody Line line) {
		Line l = lnservice.addLine(line);
		return l;
	}
				
	// http://localhost:8086/ConsomiTounsi/servlet/remove-line/{line-id}
	@DeleteMapping("/remove-line/{line-id}")
	@ResponseBody
	public void removeLine (@PathVariable("line-id") Long id_line) {
		lnservice.deleteLine(id_line);
	}
					
	// http://localhost:8086/ConsomiTounsi/servlet/modify-line
	@PutMapping("/modify-line")
	@ResponseBody
	public Line modifyLine(@RequestBody Line line) {
		return lnservice.updateLine(line);
	}

}
