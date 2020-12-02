/*package net.e3.Tuiendaprueba.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.e3.Tuiendaprueba.entity.Producto;
import net.e3.Tuiendaprueba.exception.RecordNotFoundException;
import net.e3.Tuiendaprueba.img.PictureService;
import net.e3.Tuiendaprueba.service.ProductoService;

public class PedidoController {
	@RestController
	@CrossOrigin(origins = "*")
	@RequestMapping("/api/v1")
	public class ProductoController {
		@Autowired
		ProductoService service;
		
		@Autowired
		PictureService picService;
		
		@Value("${upload.path}")
		public String uploadDir;
		
		@GetMapping("/pedido")
		public ResponseEntity<List<Producto>> getAll() {
			List<Producto> list = service.getAll();
			return new ResponseEntity<List<Producto>>(list, new HttpHeaders(), HttpStatus.OK);
		}

		@GetMapping("/pedido/{id}")
		public ResponseEntity<Producto> getProductoById(@PathVariable("id") Long id) throws RecordNotFoundException {
			Producto entity = service.findById(id);
			return new ResponseEntity<Producto>(entity, new HttpHeaders(), HttpStatus.OK);
		}
		
		@GetMapping("/pedido/pic/{id}")
	    public void getPhotoByID(@PathVariable("id") UUID id, HttpServletResponse response) throws IOException {    	
	    	Path p = Paths.get(uploadDir + File.separator + id.toString()+".jpg");
	    	System.out.println(p);
	    	InputStream is = new FileInputStream(p.toFile());
	    	response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	        StreamUtils.copy(is, response.getOutputStream()); 
	        is.close();
	    }



		@PostMapping("/pedido")
		public ResponseEntity<Producto> createProducto(@RequestParam("producto") String s, @RequestParam("img") LinkedList<MultipartFile> file, @RequestParam("img2") LinkedList<MultipartFile> file2, @RequestParam("img3") LinkedList<MultipartFile> file3) throws JsonMappingException, JsonProcessingException{
			
			ObjectMapper om = new ObjectMapper();
			Producto producto=om.readValue(s, Producto[].class)[0];
			
			if (!file.isEmpty()) {
				UUID idPic = UUID.randomUUID();
				picService.uploadPicture(file.get(0), idPic);
				producto.setImagen1(idPic);
			}
			if (!file2.isEmpty()) {
				UUID idPic = UUID.randomUUID();
				picService.uploadPicture(file2.get(0), idPic);
				producto.setImagen2(idPic);
			}
			if (!file3.isEmpty()) {
				UUID idPic = UUID.randomUUID();
				picService.uploadPicture(file3.get(0), idPic);
				producto.setImagen3(idPic);
			}
			
			service.createProducto(pedido);
			return new ResponseEntity<Producto>(producto, new HttpHeaders(), HttpStatus.OK);
		}

		@PutMapping("/pedido")
		public ResponseEntity<Producto> updateProducto(@RequestParam("producto") String s, @RequestParam("img") LinkedList<MultipartFile> file, @RequestParam("img2") LinkedList<MultipartFile> file2, @RequestParam("img3") LinkedList<MultipartFile> file3) throws RecordNotFoundException, JsonMappingException, JsonProcessingException{
			
			ObjectMapper om = new ObjectMapper();
			Producto producto=om.readValue(s, Producto[].class)[0];
			
			if (!file.isEmpty()) {
				picService.deletePicture(producto.getImagen1());
				UUID idPic = UUID.randomUUID();
				picService.uploadPicture(file.get(0), idPic);
				producto.setImagen1(idPic);;
			}
			if (!file2.isEmpty()) {
				picService.deletePicture(producto.getImagen2());
				UUID idPic = UUID.randomUUID();
				picService.uploadPicture(file2.get(0), idPic);
				producto.setImagen2(idPic);;
			}
			if (!file3.isEmpty()) {
				picService.deletePicture(producto.getImagen3());
				UUID idPic = UUID.randomUUID();
				picService.uploadPicture(file3.get(0), idPic);
				producto.setImagen3(idPic);;
			}
			
			service.updateProducto(producto);
			return new ResponseEntity<Producto>(producto, new HttpHeaders(), HttpStatus.OK);
		}

		@DeleteMapping("/producto/{id}")
		public HttpStatus deleteProductoById(@PathVariable("id") Long id) throws RecordNotFoundException {
			Producto producto=service.findById(id);
			picService.deletePicture(producto.getImagen1());
			picService.deletePicture(producto.getImagen2());
			picService.deletePicture(producto.getImagen3());
			
			service.deleteProductoById(id);
			return HttpStatus.OK;
		}
}
*/