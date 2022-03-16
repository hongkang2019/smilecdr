package techotakus.pythontrainningplatform.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import techotakus.pythontrainningplatform.JavaBean.Book;
import techotakus.pythontrainningplatform.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    UserDao userDao;
    public List<Book> bookA(String name) {
        List<Book> books = new ArrayList<>();
        if (name.equals("xxx")) {
            Book bo = new Book();
            bo.setAuthor("yhk");
            bo.setId(1234567);
            bo.setPage(223);
            bo.setName("Spring");
            books.add(bo);
            userDao.insertUser("python", "train");
            return books;
        }
        return books;
    }
}

