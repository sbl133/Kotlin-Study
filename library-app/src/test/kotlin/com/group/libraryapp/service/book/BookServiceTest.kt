package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.group.libraryapp.dto.book.request.BookLoanRequest
import com.group.libraryapp.dto.book.request.BookRequest
import com.group.libraryapp.dto.book.request.BookReturnRequest
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookServiceTest @Autowired constructor(
    private val bookService: BookService,
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryRepository
) {

    @AfterEach
    fun clean() {
        bookRepository.deleteAll()
        userRepository.deleteAll()
    }

    @Test
    fun saveBookTest() {
        //given
        val request = BookRequest("이상한 나라의 앨리스")

        //when
        bookService.saveBook(request)

        //then
        val books = bookRepository.findAll()
        assertThat(books).hasSize(1)
        assertThat(books[0].name).isEqualTo("이상한 나라의 앨리스")
    }

    @Test
    fun loanBookTest() {
        //given
        bookRepository.save(Book("이상한 나라의 앨리스"))
        val savedUser = userRepository.save(User("이승범", null))
        val request = BookLoanRequest("이승범", "이상한 나라의 앨리스")

        //when
        bookService.loanBook(request)

        //then
        val results = userLoanHistoryRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].bookName).isEqualTo("이상한 나라의 앨리스")
        assertThat(results[0].user.id).isEqualTo(savedUser.id)
        assertThat(results[0].isReturn).isFalse
    }

    @Test
    fun loanBookFailTest() {
        //given
        bookRepository.save(Book("이상한 나라의 앨리스"))
        val savedUser = userRepository.save(User("이승범", null))
        userLoanHistoryRepository.save(UserLoanHistory(savedUser, "이상한 나라의 앨리스", false))
        val request = BookLoanRequest("이승범", "이상한 나라의 앨리스")

        //when
        //then
        val message = assertThrows<IllegalArgumentException> {
            bookService.loanBook(request)
        }.message
        assertThat(message).isEqualTo("진작 대출되어 있는 책입니다")
    }

    @Test
    fun returnBookTest() {
        //given
        bookRepository.save(Book("이상한 나라의 앨리스"))
        val savedUser = userRepository.save(User("이승범", null))
        userLoanHistoryRepository.save(UserLoanHistory(savedUser, "이상한 나라의 앨리스", false))
        val request = BookReturnRequest("이승범", "이상한 나라의 앨리스")

        //when
        bookService.returnBook(request)

        //then
        val results = userLoanHistoryRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].isReturn).isTrue
    }

}