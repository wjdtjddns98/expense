package mysite.expense.service;

import lombok.RequiredArgsConstructor;
import mysite.expense.dto.ExpenseDTO;
import mysite.expense.entity.Expense;
import mysite.expense.repository.ExpenseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // final 이 붙은 필드를 생성자로 만들어줌
// 생성자 주입을 해줌, lombok 이용해서 하는법
public class ExpenseService {


    private final ExpenseRepository expRepo;
    private final ModelMapper modelMapper;
    
    // alt + insert 로 생성자 만듬, @Autowired 사용하지않고 생성자 사용으로 처리
    // 생성자 주입 , 이 방법을 권장
   /* public ExpenseService(ExpenseRepository expRepo) {
        this.expRepo = expRepo;
    } */

    // 모든 비용 리스트를 가져옴
    public List<ExpenseDTO> getAllExpenses () {
        List<Expense> list = expRepo.findAll();
        List<ExpenseDTO> listDTO = list.stream() // 스트림으로 변환
                                    .map(this::mapToDTO) // mapToDTO 로 모두 변환됨
                                 // .map(e->mapToDTO(e)) 람다식
                                    .collect(Collectors.toList()); // 다시 리스트로
        return listDTO;
    }
    // 엔티티 => DTO 변환 (값을 전달)
    private ExpenseDTO mapToDTO(Expense expense) {
       /* ExpenseDTO expenseDTO = new ExpenseDTO(); // 빈객체
        expenseDTO.setId(expense.getId());
        expenseDTO.setExpenseId(expense.getExpenseId());
        expenseDTO.setAmount(expense.getAmount());
        expenseDTO.setName(expense.getName());
        expenseDTO.setDescription(expense.getDescription());
        expenseDTO.setDate(expense.getDate());*/
        ExpenseDTO expenseDTO = modelMapper.map(expense, ExpenseDTO.class);
        return expenseDTO;
    }
}
