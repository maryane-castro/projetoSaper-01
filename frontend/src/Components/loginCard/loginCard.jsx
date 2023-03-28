import {Link} from 'react-router-dom';

const LoginCard = () => {
    return(
        <div class="card shadow-lg">
            <div class="card-body p-5">
                <h1 class="fs-4 card-title fw-bold mb-4">Login</h1>
                <form method="POST" class="needs-validation" novalidate="" autocomplete="off">
                    <div class="mb-3">
                        <label class="mb-2 text-muted" htmlFor="email">E-Mail Address</label>
                        <input id="email" type="email" class="form-control" name="email" value="" required autofocus/>
                        <div class="invalid-feedback">
                            Email is invalid
                        </div>
                    </div>

                    <div class="mb-3">
                        <div class="mb-2 w-100">
                            <label class="text-muted" htmlFor="password">Password</label>
                            <a href="forgot.html" class="float-end">
                                Forgot Password?
                            </a>
                        </div>
                        <input id="password" type="password" class="form-control" name="password" required/>
                        <div class="invalid-feedback">
                            Password is required
                        </div>
                    </div>

                    <div class="d-flex align-items-center">
                        <div class="form-check">
                            <input type="checkbox" name="remember" id="remember" class="form-check-input"/>
                            <label htmlFor="remember" class="form-check-label">Remember Me</label>
                        </div>
                        <button type="submit" class="btn btn-primary ms-auto">
                            Login
                        </button>
                    </div>
                </form>
            </div>
            <div class="card-footer py-3 border-0">
                <div class="text-center">
                    Don't have an account? <Link to='/auth/register'  class="text-dark">Create One</Link>
                </div>
            </div>
		</div>
    );
};

export default LoginCard;