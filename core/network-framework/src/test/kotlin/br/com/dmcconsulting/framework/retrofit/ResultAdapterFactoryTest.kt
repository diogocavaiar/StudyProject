package br.com.dmcconsulting.framework.retrofit

import br.com.dmcconsulting.framework.result.ResponseAsync
import io.mockk.Call
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.http.GET
import kotlin.reflect.javaType

interface ApiService {
    @GET("/endpoint")
    fun getData(): retrofit2.Call<ResponseAsync<String>>
}

class ResultAdapterFactoryTest {

    private lateinit var server: MockWebServer
    private lateinit var retrofit: Retrofit

    @Before
    fun setup() {
        server = MockWebServer()
        retrofit = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .build()
    }

    @After
    fun teardown() {
        server.shutdown()
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun `create CallAdapter for ResponseAsync`() {
        val factory = ResultAdapterFactory()
        val annotations = emptyArray<Annotation>()

        val callAdapter = factory.get(ApiService::getData.returnType.javaType, annotations, retrofit)

        assertNotNull(callAdapter)
    }

    @Test
    fun `do not create CallAdapter for non-ResponseAsync type`() {
        val factory = ResultAdapterFactory()
        val annotations = emptyArray<Annotation>()

        val callAdapter = factory.get(String::class.java, annotations, retrofit)

        assertNull(callAdapter)
    }

    @Test
    fun `do not create CallAdapter for non-parameterized type`() {
        val factory = ResultAdapterFactory()
        val annotations = emptyArray<Annotation>()

        val callAdapter = factory.get(Call::class.java, annotations, retrofit)

        assertNull(callAdapter)
    }

}