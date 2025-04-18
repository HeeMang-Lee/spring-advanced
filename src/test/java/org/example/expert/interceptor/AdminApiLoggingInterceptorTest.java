package org.example.expert.interceptor;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.example.expert.config.WebConfig;
import org.example.expert.domain.comment.controller.CommentAdminController;
import org.example.expert.domain.comment.service.CommentAdminService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = CommentAdminController.class)
@Import({AdminApiLoggingInterceptor.class, WebConfig.class})
class AdminApiLoggingInterceptorTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CommentAdminService commentAdminService;

	@Test
	@DisplayName("어드민 API 접근 시 로그가 출력되는지 확인")
	void adminApiLoggingTest() throws Exception {
		// given
		Long commentId = 1L;

		// when & then
		mockMvc.perform(delete("/admin/comments/" + commentId))
			.andExpect(status().isOk());
	}
}
