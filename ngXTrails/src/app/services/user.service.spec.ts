import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController, TestRequest } from '@angular/common/http/testing';
import { UserService } from './user.service';

describe('UserService', () => {

  let userService: UserService;
  let HttpTestingController: HttpTestingController;


  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [UserService]
    });

    userService = TestBed.inject(UserService);
    HttpTestingController = TestBed.get(HttpTestingController)
  });

  it('should get user', () => {
    userService.getUser()
    expect(userService).toBeTruthy();
  });
});
