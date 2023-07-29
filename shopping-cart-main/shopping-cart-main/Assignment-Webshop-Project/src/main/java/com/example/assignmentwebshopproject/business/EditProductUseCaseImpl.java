package com.example.assignmentwebshopproject.business;


import com.example.assignmentwebshopproject.business.impl.EditProductUseCase;
import com.example.assignmentwebshopproject.configuration.exception.ProductNotFoundWithThatIDException;
import com.example.assignmentwebshopproject.dto.EditProductRequestDTO;
import com.example.assignmentwebshopproject.persistence.ProductRepository;
import com.example.assignmentwebshopproject.persistence.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditProductUseCaseImpl implements EditProductUseCase {
    private final ProductRepository productRepository;

    @Override
    public Product EditProduct(EditProductRequestDTO request, Long Id) {

        return productRepository.findById(Id)

                .map(product->{

                    product.setName(request.getName());
                    product.setAvailablequantity(request.getAvailablequantity());
                    product.setPrice(request.getPrice());
                    product.setCategory(request.getCategory());

                    return  productRepository.save(product);
                }).orElseThrow( ()->new ProductNotFoundWithThatIDException(Id));

    }

//    @Transactional
//    @Override
//    public EditUserResponseDTO editUser(EditUserRequestDTO request) {
        //String encodedPassword = passwordEncoder.encode(request.getPassword());

//        if (requestAccessToken.getUserId() != request.getId()){
//            throw new UnauthorizedDataAccessException("STUDENT_ID_NOT_FROM_LOGGED_IN_USER");
//        }

//        User editUser = User.builder().id(request.getId()).email(request.getEmail()).firstname(request.getFirstname()).lasttname(request.getLasttname())
//                .username(request.getUsername()).password(request.getPassword())
//
//                .role(request.getRole()).build();

        //editUser.setUserRoles(Set.of(UserRole.builder().id(request.getId()).user(editUser).role(RoleEnum.STUDENT).build()));

        //User getUser = userRepository.save(editUser)
        //return EditUserResponseDTO.builder().id(getUser.getId()).email(getUser.getEmail()).userame(request.getUsername())

        //.firstname(getUser.getFirstname()).password(request.getPassword()).build();
        //}
        //}

    }
